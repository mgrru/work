const yay = () => console.log("yay")
const neverhappens = () => console.log("neverhappens")
switch (1 + 3) {
  case 2 + "2":
    yay()
    break
  default:
    neverhappens()
}

class Person {
  constructor(name, age) {
    this.name = name
    this.age = age
  }
}

const me = new Person("me", 18)
console.log("me", me);

["dog", "cat", "hen"].forEach((currentValue, index, array) => {
  // 操作 currentValue 或者 array[index]
  console.log("currentValue", currentValue)
  console.log("arr[" + index + "]", array[index])
});

["dog", "cat", "hen"].forEach(c => {
  // 操作 currentValue 或者 array[index]
  console.log("c", c)
  // console.log("arr[" + index + "]", array[index])
})

const animal = ["dog", "cat", "hen"]
for (const i of animal) {
  console.log("animal", i)
}
animal.forEach(i => console.log("i", i))
animal
  .filter(i => i != "dog")
  .forEach(i => console.log("filter", i))