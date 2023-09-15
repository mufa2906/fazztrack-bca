// VAR
console.log("halo dari vscode");
var globalVariables = "global variable global scope reassign=true";
console.log(globalVariables);
globalVariables = "reassign";
console.log(globalVariables);

// LET
let email = "block scope reassign=true";
console.log(email);
email = "reassign";
console.log(email);

// CONST block scope
const PI = 3.14;
console.log(PI);
// PI = "reassign=false"
// console.log(PI)

// String Literal
let fname = "m farhan";
let lname = "junaldi";
let fullname = `${fname} ${lname}`;
console.log(fullname);

{
  // Array
  // arrnum =[1,2,3,4,5] kalau ga ditulis type jadi var/global scope
  let arrnum = [1, 2, 3, 4, 5];
  console.log(arrnum);
}

//Object atau yg dikenal JSON
const user = {
  email: "farhan@gmail.com",
  password: "gatau",
};
console.log(user.email);

const angka = 100;
// perbandingan
//  == compare value saja
//  === compare velue dan tipe data
if (angka == "100") {
  console.log(`compare value ${angka}`);
} else {
  console.log("tidak");
}
if (angka === "100") {
  console.log(`tidak`);
} else {
  console.log(`compare value dan tipe data ${angka}`);
}

// Ternary Operator
if (angka < 10 ? false : true) {
  console.log("ternary operator");
}

// looping
// for(let i=0; i<10;i++){
//   console.log(i)
// }
// while (condition) {
// }
// do {

// } while (condition);

// function
// 1. declare func
function jumlahDuaAngka(angka1, angka2) {
  console.log(`${angka1} + ${angka2} = ${angka1 + angka2}`);
}
jumlahDuaAngka(5, 2);

// 2.variable function
let kurangDuaAngka = function (angka1, angka2) {
  console.log(`${angka1} - ${angka2} = ${angka1 - angka2}`);
};
kurangDuaAngka(5, 2);

// 3.Arrow function : ES6
let kaliDuaAngka = (angka1, angka2) => {
  console.log(`${angka1} * ${angka2} = ${angka1 * angka2}`);
};
kaliDuaAngka(5,2)
