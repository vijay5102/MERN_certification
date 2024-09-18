const { MongoClient } = require('mongodb');
// or as an es module:
// import { MongoClient } from 'mongodb'

// Connection URL
const url = 'mongodb+srv://vijayavigneshwar:Vijay21202@cluster0.evzys.mongodb.net/';
const client = new MongoClient(url);

// Database Name
const dbName = 'office';

async function inserted(){
    let empData = {
        "name":"vijay",
        "age":"22",
        "address":"chennai"

    }

    const db = client.db(dbName);
    const collection = db.collection('employee');
    const data = await db.collection('employee');
    await collection.insertOne(empData);
    console.log("inserted");
}
inserted()