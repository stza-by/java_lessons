

// let number = 10;
// let str = '23wefw45';

// let strToNumber = Number(str);

// console.log(strToNumber + number);

// let variable = null;

// console.log(variable);

// // alert('alarm');

// let age = Number(prompt('Ваш возраст?', 18));

// if(age < 18) {
//   alert('Доступ запрещен');
// } else {
//   alert('Доступ разрешен');

//   let answer = confirm(`Вам действительно ${age} лет?`)
//   console.log(answer);
// }

// function fName(name, age, height) {
//   console.log(name);
//   console.log(age);
//   console.log(height);

//   // return age + height;
//   // return undefined;
// }


// const fNameResult = fName("Jo", 12, 145);

// console.log('Result: ', fNameResult);

// function max(a, b) {
//   if (a > b) {
//     return a;
//   } else {
//     return b;
//   }
// }

// console.log(max(10, 1000));

// const max2 = function (a, b) {
//   if (a > b) {
//     return a;
//   } else {
//     return b;
//   }
// }

// const max3 = (a, b) => {
//   if (a > b) {
//     return a;
//   } else {
//     return b;
//   }
// }

// const calculator = (a, b, operator) => {
//   let answer = null;

//   switch (operator){
//     case '+':
//       answer = a + b;
//       break;
//     case '-':
//       answer = a - b;
//       break;
//     case '*':
//       answer = a * b;
//       break;
//     case '/':
//       answer = a / b;
//       break;
//     default: 
//   }
//   return answer;
// }

// console.log(calculator(10, 101, '*'));

// const array = [];

// array.push('first');
// array.push('second');
// array.pop();


// array.unshift('unshift');
// array.shift();


// array[0] = 'changed';
// array[1] = 'second';
// array[2] = 'third';


// array.splice(1, 1, 'new');

// for(let i= 0; i< array.length; i++) {
//   console.log(array[i])
// }

// for(let arrayElement of array){
//   console.log(arrayElement);
// }


const obj = {};
const obj2 = new Object();


const human = {
  name: 'Max',
  age: '22',
  job: {
    position: 'Director',
    expirience: 3
  },
  getName: function() {
    return this.name;
  },
  testF: () => {
    console.log(this);
  }
}

console.log(human);
console.log(human.getName())
human.testF();

human.name ='new name'