var http = require("http");
http.createServer(serverconfig).listen(2020);
function serverconfig(req,res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.end('Hello World\n');
}
console.log("Node server is running on port number 2020");