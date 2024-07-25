const link_a = document.getElementsByTagName("a")

const link_to = (url) => {
    location.assign(url)
}

for (let i = 0; i < link_a.length; i++) {
    let innerHTML = link_a.item(i).innerHTML
    if (innerHTML.includes("春")) {
        link_a.item(i).onclick = () => link_to("spring.html")
    } else if (innerHTML.includes("夏")) {
        link_a.item(i).onclick = () => link_to("summer.html")
    } else if (innerHTML.includes("秋")) {
        link_a.item(i).onclick = () => link_to("autumn.html")
    } else if (innerHTML.includes("冬")) {
        link_a.item(i).onclick = () => link_to("winter.html")
    } else if (innerHTML === "前进") {
        link_a.item(i).onclick = () => history.forward()
    } else if (innerHTML === "后退") {
        link_a.item(i).onclick = () => history.back()
    } else if (innerHTML.includes("刷新")) {
        link_a.item(i).onclick = () => location.reload()
    }
}