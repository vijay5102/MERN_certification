var express = require("express")
var app = express();
app.use(express.json());


app.get("/Vijay",(req,res)=>{
    res.json({"msg":"Vijay"});
});


app.post("/vijay",(req,res)=>{
    res.json({"vijay":"its's vijaya vigneshwar"})
});

app.post("/register",(req,res)=>{
    let {name,email,password,address} =req.body;
if(!name || !email || !password || !address){
    res.json({msg:"fill details"})
}else{
    res.json({msg:"registerd successfully"})
}  
});

app.post("/login",(req,res)=>{
    let email = req['query']['email'];
    let pwd = req['query']['password'];
if(email == 'admin@gmail.com' && pwd =='admin' ){
    res.json({"msg":"you are correct"})
}else{
    res.json({"msg":"you are wrong"})
}
    //console.log(email,pwd);
    //res.json({"msg":email})
});
 
var {MongoClient,ObjectId} = require('mongodb');

const DATABASE_NAME = "office"
const MONGODB_URL = ' mongodb_url';
const client = new MongoClient('mongodb+srv://vijayavigneshwar:Vijay21202@cluster0.evzys.mongodb.net/');

app.post("/createEmployee",async(req,res)=>{
    let {name,email,password,mobile_no} = req.body;
    let data = {
        'name' : 'vijay',
        'email': 'vijay@gmail.com',
        'password':'1234',
        'address':'chennai',
        'mobile_no':'7418989959'
    }
    await client.connect();
    //select the database from mongodb server
    let db = client.db(DATABASE_NAME);
    //insert only the data from into the collection
     await db.collection("employee").insertOne(data);
     res.status(200).json({"message":"employee created!!"})

});


app.get("/createEmployee",async(req,res)=>{
    await client.connect();
    let db = client.db("Office");
    let list = await db.collection("employee").find({}).toArray();
    res.status(200).json(list)
});


    
app.get("/listempbyname/:name",async(req,res)=>{
    await client.connect();
    let {name} = req.params;
    let db = client.db("office");
    let list = await db.collection("employee").find({"name":name}).toArray();
    res.status(200).json(list)
});

app.post("/loginn",async(req,res)=>{
    await client.connect();
    let {name,password} = req.body;
    let db = client.db("office");
    let list = await db.collection("employee").find({"name":name,"password":password}).toArray();
    

if(list.length>0){
    res.json({"msg":"you are correct"})
}else{
        res.status(400).json({"msg":"you are wrong"})
}
});

app.get("/filter", async (req,res) => {
    await client.connect();
    let db = client.db('office');
    var filterList = {};
    let{name,email,mobile_no} = req.query;
    if(name != undefined && name !=''){
      filterList['name'] = name;
    }
    else if(email != undefined && email!=''){
      filterList['email'] = email;
    }
    else if(mobile_no != undefined && mobile_no != '' ){
      filterList['phone'] = mobile_no;
  
    }
    let list = await db.collection("employee").find(filterList).toArray();
    res.json(list);
  });
  
  
  app.delete("/deleteUserName",async (req,res) => {
    await client.connect();
    let db = client.db('office');
  
    let { name } = req.query;
    await db.collection("employee").deleteOne({name : name});
    res.json({"msg": "User Deleted"});
    
  });
  
  app.put("/updatepwd" , async (req,res) => {
    let {name , password} = req.query;
    await client.connect();
    let db = client.db("office");
    await db.collection("employee").updateOne({"name" : name},{$set: {"password": password}});
    res.json({"msg": "Password is updated!!"})
    
  });

  app.get("/getById",async(req,res)=>{
    let{id} = req.query;
    await client.connect();
    let db = client.db("office");
    let data = await
    db.collection("employee").find({"_id":new ObjectId(id)}).toArray();
    res.json(data)
  })

app.listen(8080,()=>{
    console.log("server started") 

});



