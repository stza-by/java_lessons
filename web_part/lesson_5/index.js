class Calculator {
  constructor(prevElement, currentElement) {
    this.prevElement = prevElement;
    this.currentElement = currentElement;
  }

  clearAll() {
    this.currentElement.innerText = '';
    this.prevElement.innerText = '';
    this.operator = undefined;
  }

  delete() {
    if (this.currentElement.innerText === '') return;

    this.currentElement.innerText = this.currentElement.innerText.slice(0, -1);
  }

  appendNumber(number) {
    if (number === '.' && this.currentElement.innerText.includes('.')) return;


    if(this.isComputed && this.prevElement.innerText === '') this.clearAll();

    this.currentElement.innerText = this.currentElement.innerText.concat(number);
  }

  chooseOperator(operator) {
    if(this.currentElement.innerText === '') return;

    if(this.prevElement.innerText !== '') this.compute();

    this.operator = operator;
    this.prevElement.innerText = this.currentElement.innerText.concat(' ' + operator);
    this.currentElement.innerText = '';
  }

  compute() {
    let result;

    const prevNumber = parseFloat(this.prevElement.innerText);
    const currentNumber = parseFloat(this.currentElement.innerText);

    if(isNaN(prevNumber) || isNaN(currentNumber)) return;

    switch (this.operator){
      case '+':
        result = prevNumber + currentNumber;
        break;
      case '-':
        result = prevNumber - currentNumber;
        break;
      case '*':
        result = prevNumber * currentNumber;
        break;
      case '÷':
        result = prevNumber / currentNumber;
        break;
      default: return;
    }

    this.currentElement.innerText = result;
    this.prevElement.innerText = '';
    this.operator = undefined;
    this.isComputed = true;
  }
}

const numberButtons = document.querySelectorAll('[data-number]');
const operationButtons = document.querySelectorAll('[data-operation]');
const equalsButton = document.querySelector('[data-equals]');
const deleteButton = document.querySelector('[data-delete]');
const allClearButton = document.querySelector('[data-all-clear]');

const prevElement = document.querySelector('[data-previous-operand]');
const currentElement = document.querySelector('[data-current-operand]');


const calculator = new Calculator(prevElement, currentElement);

equalsButton.addEventListener('click', () => {
  calculator.compute();
})


allClearButton.addEventListener('click', () => {
  calculator.clearAll();
})

deleteButton.addEventListener('click', () => {
  calculator.delete();
})

numberButtons.forEach((button) => {
  button.addEventListener('click', () => {
    calculator.appendNumber(button.innerText);
  })
})

operationButtons.forEach(button => {
  button.addEventListener('click', () => {
    calculator.chooseOperator(button.innerText);
  })
})







