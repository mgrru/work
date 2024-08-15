{
  description = "A Nix-flake-based Node.js development environment";
  nixConfig = {
    substituters = [
      "https://mirrors.ustc.edu.cn/nix-channels/store"
      "https://mirrors.tuna.tsinghua.edu.cn/nix-channels/store"
      "https://mirror.sjtu.edu.cn/nix-channels/store"
      "https://nix-community.cachix.org"
      "https://cache.nixos.org"
    ];
  };

  inputs = {
    nixpkgs.url = "https://mirrors.ustc.edu.cn/nix-channels/nixpkgs-unstable/nixexprs.tar.xz";
  };

  outputs =
    { nixpkgs, ... }:
    let
      # system should match the system you are running on
      system = "x86_64-linux";
    in
    # system = "x86_64-darwin";
    {
      devShells."${system}".default =
        let
          pkgs = import nixpkgs { inherit system; };
        in
        pkgs.mkShell {
          packages = with pkgs; [
            nodejs_22
            nodePackages.pnpm
            (pnpm.override { nodejs = nodejs_22; })
          ];

          shellHook = ''
            echo "`node -v`"
            pnpm config set registry https://registry.npmmirror.com/
          '';
        };
    };
}
