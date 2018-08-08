var i = 1; /* Set Global Variable i */
function increment(){
i += 1; /* Function for automatic increment of field's "Name" attribute. */
}
/*
---------------------------------------------

Function to Remove Form Elements Dynamically
---------------------------------------------

*/
function gqmFunction(){

var x=i;
if(x<4){
var r=document.createElement("div");
r.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","goalIntention_"+i);
var t=document.createTextNode("Intention");
b.appendChild(t);
r.appendChild(b);

var x=document.createElement("div");
x.setAttribute("class","col-md-4");


var y=document.createElement("INPUT");
y.setAttribute("type","text");
y.setAttribute("id","goalIntention_"+i);
y.setAttribute("placeholder","A goal with issue+purpose+object");
y.setAttribute("class","form-control input-md");
x.appendChild(y);
r.appendChild(x);
document.getElementById("gqmform").appendChild(r);
/////////////////////////////////////////////////////////////////////////////////////////////

var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","goalTarget_"+i);
var t=document.createTextNode("Target");
b.appendChild(t);
q.appendChild(b);

var x=document.createElement("div");
x.setAttribute("class","col-md-4");


var z=document.createElement("select");
z.setAttribute("id","goalTarget_"+i);
z.setAttribute("class","form-control form-control-sm");
var m=document.createElement("option");
var t=document.createTextNode("PM");
m.appendChild(t);
z.appendChild(m);
//22
var m=document.createElement("option");
var t=document.createTextNode("Business");
m.appendChild(t);
z.appendChild(m);
//
x.appendChild(z);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);
/////////////////////////////////////////////////////////////////////////////////////////////

var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","toolU_"+i);
var t=document.createTextNode("Tools");
b.appendChild(t);
q.appendChild(b);


var x=document.createElement("div");
x.setAttribute("class","col-md-4");

var w=document.createElement("INPUT");
w.setAttribute("type","text");
w.setAttribute("id","toolUsed_"+i);
w.setAttribute("placeholder","Use <,> if this many tools serves the same purpose");
w.setAttribute("class","form-control input-md");
x.appendChild(w);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);
/////////////////////////////////////////////////////////////////////////////////////////////

var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","pluginUsed_"+i);
var t=document.createTextNode("Plugins");
b.appendChild(t);
q.appendChild(b);


var x=document.createElement("div");
x.setAttribute("class","col-md-4");

var a=document.createElement("INPUT");
a.setAttribute("type","text");
a.setAttribute("id","pluginUsed_"+i);
a.setAttribute("placeholder","Use <,> if many plugin generates the same outputs");
a.setAttribute("class","form-control input-md");
x.appendChild(a);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);
/////////////////////////////////////////////////////////////////////////////////////////////

var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","plugcat_"+i);
var t=document.createTextNode("Category");
b.appendChild(t);
q.appendChild(b);

var x=document.createElement("div");
x.setAttribute("class","col-md-4");


var z=document.createElement("select");
z.setAttribute("id","plugcat_"+i);
z.setAttribute("class","form-control form-control-sm");
var m=document.createElement("option");
var t=document.createTextNode("Discovery");
m.appendChild(t);
z.appendChild(m);
//22
var m=document.createElement("option");
var t=document.createTextNode("Conformance Checking");
m.appendChild(t);
z.appendChild(m);
//
var m=document.createElement("option");
var t=document.createTextNode("Enhancement");
m.appendChild(t);
z.appendChild(m);
//
var m=document.createElement("option");
var t=document.createTextNode("Analytic");
m.appendChild(t);
z.appendChild(m);
//
x.appendChild(z);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);
/////////////////////////////////////////////////////////////////////////////////////////////

var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","filter_"+i);
var t=document.createTextNode("Filtering");
b.appendChild(t);
q.appendChild(b);


var x=document.createElement("div");
x.setAttribute("class","col-md-4");

var a=document.createElement("INPUT");
a.setAttribute("type","text");
a.setAttribute("id","filter_"+i);
a.setAttribute("placeholder","Yes/No+ optional(plugin)");
a.setAttribute("class","form-control input-md");
x.appendChild(a);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);

/////////////////////////////////////////////////////////////////////////////////////////////
var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","output_"+i);
var t=document.createTextNode("Outputs");
b.appendChild(t);
q.appendChild(b);


var x=document.createElement("div");
x.setAttribute("class","col-md-4");

var a=document.createElement("INPUT");
a.setAttribute("type","text");
a.setAttribute("id","output_"+i);
a.setAttribute("placeholder","Use <,> if many outputs were generated");
a.setAttribute("class","form-control input-md");
x.appendChild(a);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);
/////////////////////////////////////////////////////////////////////////////////////////////

var q=document.createElement("div");
q.setAttribute("class","form-group");

var b=document.createElement("label");
b.setAttribute("class","col-md-4 control-label");
b.setAttribute("for","issue_"+i);
var t=document.createTextNode("Reported Issues");
b.appendChild(t);
q.appendChild(b);


var x=document.createElement("div");
x.setAttribute("class","col-md-4");

var a=document.createElement("INPUT");
a.setAttribute("type","text");
a.setAttribute("id","issue_"+i);
a.setAttribute("placeholder","Problem mentioned");
a.setAttribute("class","form-control input-md");
x.appendChild(a);
q.appendChild(x);
document.getElementById("gqmform").appendChild(q);

/////////////////////////////////////////////////////////////////////////////////////////////
increment();
}else{document.getElementById("addbutton").setAttribute("class","btn btn-default btn-sm disabled");}
}

