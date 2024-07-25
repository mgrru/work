const logo = document.getElementsByClassName("logo")
const close_btn = logo.item(0).getElementsByTagName("span")
close_btn.item(0).onclick = () => {
    window.close()
}

const li = document.getElementsByTagName("li")

for (i = 0; i < li.length; i++) {
    if (li.item(i).innerHTML.includes("收藏")) {
        li.item(i).onclick = () => {
            alert("收藏")
        }
    }
    if (li.item(i).innerHTML.includes("删除")) {

        li.item(i).onclick = () => {
            alert("delete")
        }
    }

}

const price_book_1 = 21.90
const price_book_2 = 24.10

let num_book_1 = 1
let num_book_2 = 1

li.item(4).onclick = () => {
    const total_book_1 = price_book_1 * num_book_1
    const total_book_2 = price_book_2 * num_book_2

    const total_money = total_book_1 + total_book_2
    alert("结算:" + total_money)
}

const span_num_book_1 = li.item(5).getElementsByTagName("span")

span_num_book_1.item(0).onclick = () => {
    if (num_book_1 > 1) {
        num_book_1--
        span_num_book_1.item(1).innerHTML = num_book_1
    }
}

span_num_book_1.item(2).onclick = () => {
    num_book_1++
    span_num_book_1.item(1).innerHTML = num_book_1

}

const span_num_book_2 = li.item(6).getElementsByTagName("span")

span_num_book_2.item(0).onclick = () => {
    if (num_book_2 > 1) {
        num_book_2--
        span_num_book_2.item(1).innerHTML = num_book_2
    }
}

span_num_book_2.item(2).onclick = () => {
    num_book_2++
    span_num_book_2.item(1).innerHTML = num_book_2

}