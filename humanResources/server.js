var http = require("http");
var fs = require("fs");
var express = require('express');
var app = express();

app.get("/", function(req,res){
	var result = "Hello ";
	if(req.query['name'] != undefined){
		result += req.query['name'];
	}
	else{
		result += "World";
	}
	res.send(result);
	console.log(req.query);
});

app.get("/employees", function(req,res){
	fs.readFile(__dirname+"/employees.json","utf8",function(err,data){
	res.send(data);
	});
});


var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
})
