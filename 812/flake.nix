{
  description = "A Nix-flake-based Node.js development environment";
  nixConfig = {
    trusted-users = [ "ru" ];
    substituters = [
      "https://mirrors.ustc.edu.cn/nix-channels/store"
      "https://mirrors.tuna.tsinghua.edu.cn/nix-channels/store"
      "https://mirror.sjtu.edu.cn/nix-channels/store"
      "https://nix-community.cachix.org"
      "https://cache.nixos.org"
    ];
    trusted-public-keys = [
      # nix community's cache server public key
      "nix-community.cachix.org-1:mB9FSh9qf2dCimDSUo8Zy7bkq5CX+/rkCWyvRCYg3Fs="
    ];
  };

  inputs = {
    nixpkgs.url = "https://mirrors.ustc.edu.cn/nix-channels/nixpkgs-unstable/nixexprs.tar.xz";
  };

  outputs =
    { self, nixpkgs, ... }:
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
            echo "node `${pkgs.nodejs}/bin/node --version`"
          '';
        };
    };
}
