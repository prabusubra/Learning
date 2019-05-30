/**
 * what is closure?
 * Inner functions can access outer function variables and parameters but not this(call, apply, bind) and arguments array..
 *  */
function Product(options) {
  this.name = options.name ? options.name : "";
  this.price = options.price ? options.price : "";
  var availability = options.availability ? options.availability : "";
  this.getDetails = function() {
    return (
      this.name +
      ", " +
      this.price +
      ", " +
      availability +
      ", " +
      options.seller
    );
  };
}
var product = new Product({
  name: "Bread",
  price: "35",
  availability: "Instock",
  seller: "Milka"
});
det = product.getDetails.bind();
console.log(product.getDetails()); //Bread, 35, Instock, Milka
console.log(product.getDetails.call()); //undefined, undefined, Instock, Milka
console.log(product.getDetails.apply()); //undefined, undefined, Instock, Milka
console.log(product.getDetails.bind()()); //undefined, undefined, Instock, Milka
