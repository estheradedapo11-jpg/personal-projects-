function showUsername(){

    var name =document.getElementById("username").value;
    alert(name);
}

function checkAge(){
    var age= documentGetElementById("age").value;

    if(age > 18){
        alert("You are allowed");
    }
    else{
        alert("You are not allowed");
    }
}

function displaName(){

    var name = document.getElementById("name").value;
    var result = document.getElementById(result).value;

    result.innerHTML= "Hello " + name;

}

function checkAge(){

    var age=document.getElementById("age").value;
     var result=document.getElementById("result");
    if (age>=18){
        result.innerHTML="You are allowed";
        result.style.color="green";
    }
    else{
        result.innerHTML="You are not allowed";
        result.style.color="red";
    }

       


}