import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';



@Component({
  selector: 'app-korisnici',
  templateUrl: './korisnici.component.html',
  styleUrls: ['./korisnici.component.css']
})
export class KorisniciComponent implements OnInit {

    @Input("activeUser")
    activeUser = "";

    @Output("changeUser")
    change = new EventEmitter();

    @Input()
    users = [
        {
            name:"Ime"
        }
    ];

    constructor(private http: HttpClient) { }

    ngOnInit(): void {
        this.http.get("http://localhost:8080/getUsers").subscribe(res => {
            this.users = (res as any);
        })
    }

    changeActiveUser(newUser: any){
        console.log(newUser);
        this.change.emit(newUser);
        
    }

}
