"use strict";
var URL = "http://localhost:8080/restws/services/productservice/products/";
function getAllObjects(){
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", URL, false);
    xhttp.setRequestHeader("Content-Type", "application/xml");
    xhttp.send();
    var response = xhttp.responseText;
    console.log(response);
}
function getFirstObject(){
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", URL+"1", false);
    xhttp.setRequestHeader("Content-Type", "application/xml");
    xhttp.send();
    var response = xhttp.responseText;
    console.log(response);
}
function postObject(){
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, false);
    xhttp.setRequestHeader("Content-Type", "application/xml");
    var id = document.getElementById('post_id').value;
    var name = document.getElementById('post_name').value;
    var price = document.getElementById('post_price').value;
    var description = document.getElementById('post_description').value;
    var quantity = document.getElementById('post_quantity').value;
    var product =  new Product(id,name,price,description,quantity);
    console.log(product);
    var objXml = objectToXml(product);
    console.log(objXml);
    xhttp.send(objXml);
}
function updateObject(){
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", URL, false);
    xhttp.setRequestHeader("Content-Type", "application/xml");
    xhttp.send();
    var response = JSON.parse(xhttp.responseText);
}
function deleteObject(){
    var id = document.getElementById('delete_id').value;
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", URL+id, false);
    xhttp.setRequestHeader("Content-Type", "application/xml");
    xhttp.send();
}

function openTab(evt, methodName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(methodName).style.display = "block";
    evt.currentTarget.className += " active";
}

var Product = function(id,name,price,description,quantity){
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.quantity = quantity;
}

function objectToXml(obj) {
        var xml = '<Product>';

        for (var prop in obj) {
            if (!obj.hasOwnProperty(prop)) {
                continue;
            }

            if (obj[prop] == undefined)
                continue;

            xml += "<" + prop + ">";
            if (typeof obj[prop] == "object")
                xml += objectToXml(new Object(obj[prop]));
            else
                xml += obj[prop];

            xml += "</" + prop + ">";
        }
        xml+= '</Product>';
    return xml;
}