
const block = document.querySelector('.demo-1');
const button = document.querySelector('#bnt');

if(block && button) {

  const color1 = '#eb4034';
  const color2 = '#34abeb';

  let colorValue = 5;

  setInterval(() => {
    
    if(colorValue === true){
      block.style.backgroundColor = color1;
      colorValue = false
    } else {
      block.style.backgroundColor = color2;
      colorValue = true;
    }
  }, 1000);

} else {
  console.log('Error');
}

// modern
let letName = 'let value';
const constName2 = 'const value';

// old
var varName3 = 'var value';

console.log(letName, constName2, varName3);

letName = 444;

console.log(typeof letName);
console.log(typeof constName2);