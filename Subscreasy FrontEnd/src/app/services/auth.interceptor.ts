import {HttpInterceptor , HttpHandler, HttpRequest} from '@angular/common/http';

import 'rxjs/add/operator/do';


export class AutInterceptor implements HttpInterceptor{

    
    intercept(req: HttpRequest<any>, next: HttpHandler){
        /*const token = localStorage.getItem('token');


       req.headers.set('Authorization', 'bearer '+token); console.log('xx');
        return next.handle(req);
       /*req = req.clone({
            setHeaders: {
              Authorization: ('Bearer '+token)
            }
          })
          return next.handle(req);;*/
          let token: string = sessionStorage.getItem('token');
          if(token == null){token = localStorage.getItem('token'); }
          req = req.clone({
            setHeaders: {
              Authorization: `${token}`
            }
          });
         console.log(token);
         return next.handle(req);
        
    }
}