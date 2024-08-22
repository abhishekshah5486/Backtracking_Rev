// Given a function in argument, that returns an integer, multiply that with the second paraemeter which is a Number,
// return the final value
const fn2 = (fn1, val) => {
    const val2 = fn1();
    return val2 * val;
}
const fn1 = () => {
    return 3;
}
console.log(fn2(fn1, 3));
