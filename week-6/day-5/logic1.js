n = 9;
function nomor1() {
  console.log("Nomor 1")
  for (y = 1; y <= n; y++) {
    let row = "";
    for (x = 1; x <= n; x++) {
      if (x == y) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor2() {
  console.log("Nomor 2")
  for (y = 1; y <= n; y++) {
    let row = "";
    for (x = 1; x <= n; x++) {
      if (x == 10 - y) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor3() {
  console.log("Nomor 3")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (x == y || x == n - y - 1) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor4() {
  console.log("Nomor 4")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (x == y || x == 8 - y) {
        row += "* ";
      } else if (x == 4 || y == 4) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor5() {
  console.log("Nomor 5")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (x == y || x == n - y - 1) {
        row += "* ";
      } else if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor6() {
  console.log("Nomor 6")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < y + 1; x++) {
      row += "* ";
    }
    console.log(row);
  }
}

function nomor7() {
  console.log("Nomor 7")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (x >= n - y - 1) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor8() {
  console.log("Nomor 8")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (x >= y && x <= n - y - 1) {
        row += "* ";
      } else if (x <= y && x >= n - y - 1) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor9() {
  console.log("Nomor 9")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (y >= x && y <= n - x - 1) {
        row += "* ";
      } else if (y <= x && y >= n - x - 1) {
        row += "* ";
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

function nomor10() {
  console.log("Nomor 10")
  for (y = 0; y < n; y++) {
    let row = "";
    for (x = 0; x < n; x++) {
      if (y == 4) {
        row += "* ";
      } else if (x <= y && y < 4) {
        if (y < parseInt(n / 2)) {
          row += "* ";
        } else {
          row += "  ";
        }
      } else if (x >= y && y > 4) {
        if (y >= parseInt(n / 2)) {
          row += "* ";
        } else {
          row += "  ";
        }
      } else {
        row += "  ";
      }
    }
    console.log(row);
  }
}

nomor1()
nomor2()
nomor3()
nomor4()
nomor5()
nomor6()
nomor7()
nomor8()
nomor9()
nomor10()