var http = require("http");
var fs = require("fs");
var bodyParser = require('body-parser');
var express = require('express');

var app = express();

app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

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

app.post("/addEmployee", function(req,res){
	var employees = JSON.parse(fs.readFileSync(__dirname+"/employees.json"));
	employees.push(req.body);
	fs.writeFile(__dirname+"/employees.json",JSON.stringify(employees),function(err){
		res.send(err);
	});
});

app.get("/deleteEmployee", function(req, res){
	if(req.query == undefined){
		return;
	}
	if(req.query['name'] == undefined){
		res.send();
		return;
	}
	var employees = JSON.parse(fs.readFileSync(__dirname+"/employees.json"));
	
	employees = employees.filter(function(employee){ return employee.name != req.query['name'] });
	console.log(employees);
	fs.writeFile(__dirname+"/employees.json",JSON.stringify(employees),function(err){
		if(err != null){
		console.log(err);
		}
	});
	res.send();
});



var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
})
