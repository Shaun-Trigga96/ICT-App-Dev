const express = require("express");
const app = express();
const mongoose = require("mongoose");
const bodyParser = require("body-parser");

app.use(bodyPaser.urlencoded({ extended: true }))

mongoose.connect("mongodb+srv://Thabiso:ENaL*hi$9TYGE37@project-management-webs.kuckr.mongodb.net/IT-Project-Manager");

app.get("/", function(req, res) {
    res.send("express is working")
})

//app.post

app.listen(3000, function() {
    console.log("server is running on 3000")
})