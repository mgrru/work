$(document).ready(() => {
    $("div:nth-of-type(2)").css("visibility", "hidden")

    $("a").click(function () {
        $("div:nth-of-type(2)").css("visibility") === "hidden" ?
            $("div:nth-of-type(2)").css("visibility", "visible") :
            $("div:nth-of-type(2)").css("visibility", "hidden")
    })

    $("h1").click(function () {
        // $("div div h1").css("color") == "rgb(0, 0, 0)" ?
        //     $("div div h1").css("color", "blue") : 
        //     $("div div h1").css("color", "black") 

        $("div div h1").css("color", (_, color) => color === "rgb(0, 0, 0)" ? "blue" : "black")
        $("div div p").css("color", (_, color) => color === "rgb(0, 0, 0)" ? "green" : "black")
    })
})