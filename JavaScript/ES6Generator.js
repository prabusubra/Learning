function asyncRunner(generator) {
  let gen = generator();
  function rec(result) {
    if (result.done) return;
    result.value.then
      ? result.value.then(resp => {
          rec(gen.next(resp));
        })
      : rec(gen.next(result.value));
  }
  rec(gen.next());
}

function* gen() {
  let posts = yield fetch("https://jsonplaceholder.typicode.com/posts");
  let lpost = yield posts.json();
  for (let index in lpost) {
    let users = yield fetch(
      "https://jsonplaceholder.typicode.com/users/" + lpost[index].userId
    );
    let lusers = yield users.json;
    console.log(lusers);
  }
}
asyncRunner(gen);
