import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';
import { LoginService } from '../service/login.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    private userService: UserService,
    private login: LoginService
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    if(this.login.isLoggedIn() && this.login.getUserRole()=='Admin' ){
      return true;
    }
    this.router.navigate(['/login']);

    return false;  
  }

  // canActivate(
  //   route: ActivatedRouteSnapshot,
  //   state: RouterStateSnapshot
  // ):
  //   | Observable<boolean | UrlTree>
  //   | Promise<boolean | UrlTree>
  //   | boolean
  //   | UrlTree {
  //   if (this.userAuthService.getToken() !== null) {
  //     const role = route.data['roles'] as Array<string>;

  //     if (role) {
  //       const match = this.userService.roleMatch(role);

  //       if (match) {
  //         return true;
  //       } else {
  //         this.router.navigate(['/forbidden']);
  //         return false;
  //       }
  //     }
  //   }

  //   this.router.navigate(['/login']);
  //   return false;
  // }
}
