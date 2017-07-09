/**
 * http://usejsdoc.org/
 */
var http = require("http");
var server = http.createServer();
server.on('request',dataconfig);
server.listen(2021);
function dataconfig(req,res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.end('Hello World\n');
}
console.log("Node server is running on port number 2021");