import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
    toDos = [
    ]
    currentUser = "Pero";
    getUrl = "http://localhost:8080/notes/" + this.currentUser;
    postUrl = "http://localhost:8080/addNote";
    users = [];

    getUsers(){
    this.http.get("http://localhost:8080/getUsers").subscribe(response => {
        this.users = (response as any);
        })
        console.log(this.users);
        
    }

    getToDoData(){
    this.http.get(this.getUrl).subscribe(response => {
        this.toDos = (response as any);
    })
    }

    constructor(private http: HttpClient){   
    this.getToDoData();
    this.getUsers();

    }



    userChange(){
    this.getUrl = "http://localhost:8080/notes/" + this.currentUser;
    this.getToDoData(); 
    console.log(this.toDos);
    }  

    fun(obj: any){
    console.log(obj);

    }

    addToDo(ime: any){
    let postObject =   {
        "note": ime,
        "user": {
            
            "name": this.currentUser
        }
    };
    console.log(postObject);

    this.http.post(this.postUrl, postObject)
    .subscribe(response => {console.log(response);
    })
    if(this.getToDoData.length == 0)
        //location.reload();
    this.getToDoData();

    }

    doneChange(item: any){
    console.log(item);
    item.done = !item.done;
    this.http.patch("http://localhost:8080/changeDone/" + item.noteId + "/" + item.done).subscribe(response => {
        console.log(response);
        ;
        })
    }

    deleteItem(item: any){
    this.http.delete("http://localhost:8080/deleteNote/" + item.noteId).subscribe(res => {console.log(res);})
    this.getToDoData();

    //location.reload();
    }



    newUser(userName: string){
        let userObject = {name:userName};
        this.http.post("http://localhost:8080/addUser", userObject).subscribe(res => console.log(res));
        this.getUsers();
    }

    changeUser(newUser: any){
        this.currentUser = newUser.name;
        this.userChange();
    }
}
