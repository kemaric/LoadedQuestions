export function generateID () {
  const res = crypto.getRandomValues(new Uint32Array(6)).reduce((prev, curr) => (prev = (prev + curr) * 2 ** 9) && prev, 0);
  return res;
}
