
function createUser(nickName, age) {
  return {
    nickName,
    age,
    logOut: () => {
      console.log('log out')
    }
  };
}

// функиция-конструктор
function Animal(name, skinColor) {
  // this = {};
  this.name = name;
  this.skinColor = skinColor;
  this.run = () => {
    console.log('run');
  }
  // return this;
}

class Person {
  constructor(name, surname, age) {
    this.name = name;
    this.surname = surname;
    this.age = age;

    Person._instanceNumber++;
  }

  static _instanceNumber = 0;

  static getInstanseNumber = () => {
    return Person._instanceNumber;
  }

  getName = () => {
    return this.name;
  }

  getSurname () {
    return this.surname;
  }

  getAge = function () {
    return this.age;
  }
}

class Employer extends Person {
  constructor(name, surname, age, job) {
    super(name, surname, age);
    this.job = job;
  }

  getJob = () => {
    return this.job;
  }
}



const person1 = new Person('Max', 'Hutson', 18);
const person2 = new Person('Max', 'Hutson', 18);

const empl1 = new Employer('John', 'Doe', 33, 'software developer');

console.log(empl1.getName());
console.log(empl1.getJob());


// console.log(person1.getName());
// console.log(person1.getSurname());
// console.log(person1.getAge());
// console.log(Person.getInstanseNumber());

// const user1 = createUser('qwe', 12);
// console.log(user1);

// const aniamal1 = new Animal('Шарик', 'черный');
// console.log(aniamal1);