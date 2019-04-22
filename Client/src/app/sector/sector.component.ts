import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-sector',
  templateUrl: './sector.component.html',
  styleUrls: ['./sector.component.css']
})
export class SectorComponent implements OnInit {
  

  constructor(private httpService: HttpClient) { }
  selectedOption: string;
  title = ' My Portfolio';
  arrBirds: string [];
  arrayBirds: string [];
  ngOnInit() {
    this.httpService.get('./assets/Birds.json').subscribe(
      data => {
        this.arrBirds = data as string [];	 // FILL THE ARRAY WITH DATA.
        //  console.log(this.arrBirds[1]);
      },
      (err: HttpErrorResponse) => {
        console.log (err.message);
      }
    );
  }
  showAlert(){
   
      this.arrayBirds= this.arrBirds;
    
     
  }
 
}

  
