import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
baseurl='http://localhost:8080/server/signUp/users/create';
baseurl='http://localhost:8080/server/signUp/add';
  constructor(private router: Router){ 
  };

  ngOnInit() {
  }
  submit(){
    this.router.navigate(['/sector']);
  }
  cancel(){
    this.router.navigate(['/home']);
  }
  get(baseurl)
  {
      
      return this.httpService.post(baseurl).subscribe(
        data => {
          this.arrBirds = data as string [];   // FILL THE ARRAY WITH DATA.
          //  console.log(this.arrBirds[1]);
        },
        (err: HttpErrorResponse) => {
          console.log (err.message);
        }
      );
  }
    post(baseurl2)
  {
      
      return this.httpService.post(baseurl2).subscribe(
        data => {
          this.arrBirds = data as string [];   // FILL THE ARRAY WITH DATA.
          //  console.log(this.arrBirds[1]);
        },
        (err: HttpErrorResponse) => {
          console.log (err.message);
        }
      );
  }

}
