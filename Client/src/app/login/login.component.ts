import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = ' Stock and Index';
  constructor(private httpService: HttpClient) { }
  arrBirds: string [];
  symbol: any=[];
  newurl='http://localhost:8080/server/login/add';
baseurl='./assets/Birds.json';
  ngOnInit() {
    this.httpService.get(this.baseurl).subscribe(
      data => {
        this.arrBirds = data as string [];   // FILL THE ARRAY WITH DATA.
        //  console.log(this.arrBirds[1]);
      },
      (err: HttpErrorResponse) => {
        console.log (err.message);
      }
    );
    this.httpService.get('https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=NSE:GAIL&apikey=J8CRQTK9IG3HXPJG')
   .subscribe( 
    
     data =>{
     //this.xname=data.constructor();
      
     
      this.symbol = data as string [];   // FILL THE ARRAY WITH DATA.
      //  console.log(this.arrBirds[1]);
    
      console.log(JSON.stringify(data));
      
     },
     err => {
      console.log("Oops!");
  }
   )
   
  }
 
  
  
 

}




