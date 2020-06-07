// console.dir(window);


// document.title = 'Новое название';

// const h2Tegs = document.getElementsByTagName('h2');
// console.log(h2Tegs);

// const headerTitle = document.getElementById('header-title');
// console.log(headerTitle);

// headerTitle.innerText = 'Changed';

// const containers = document.getElementsByClassName('container');
// console.log(containers);

// const containers = document.querySelectorAll('.container');
// console.log(containers);

// containers[0].style.backgroundColor = 'blue';
// containers[1].style.backgroundColor = 'blue';

// const title = document.querySelector('#header-title');

 const items = document.querySelector('#items');

// for(let listItem of items.children) {
//   listItem.innerText = 'changed';
// }

const newElement = document.createElement('li');
newElement.className = 'list-group-item';
newElement.innerText = 'Элемент 5';

items.append(newElement);
