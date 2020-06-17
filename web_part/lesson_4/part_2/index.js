
const items = document.querySelector('#items');

// items.children[3].addEventListener('click', (event) => {
//   console.log('Нажатие на li  st item')
//   console.log(event);
// })

// items.addEventListener('click', (event) => {
//   console.log('Нажатие на unordered list');
//   console.log(event);
// })


const form = document.querySelector('#form');

form.addEventListener('submit', (event) => {
  console.log('submit event');
  event.preventDefault();
})


const addBotton = document.querySelector('#add-button')

addBotton.addEventListener('click', () => {
  const input = document.querySelector('#new-element-input');

  const newLi = document.createElement('li');
  newLi.className = 'list-group-item';
  newLi.innerHTML = `
  <span> ${input.value} </span>
    <button class="delete btn btn-outline-danger float-right btn-sm">
      X
    </button>`;

  items.append(newLi);

  input.value = '';
})

items.addEventListener('click', (event) => {

  if (event.target.className.includes('delete')) {
    event.target.parentElement.remove();
  }
})

items.addEventListener('click', (event) => {
  if (event.target.className.includes('list-group-item')) {
    event.target.style.backgroundColor = 'silver';
  }
})

const searchInput = document.querySelector('#search-input');

searchInput.addEventListener('keyup', (event) => {
  const searchText = event.target.value;

  const listItems = items.children;

  for (const element of listItems) {
    if(element.children[0].textContent.includes(searchText)){
      element.style.display = 'block';
    } else {
      element.style.display = 'none';
    }
  }
}) 

// element.style.backgroundColor = 'rgb(10, 23, 124)'

