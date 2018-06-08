import {Injectable} from '@angular/core';
import {HttpClient, HttpHandler, HttpInterceptor, HttpParams, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  private hosturl = 'http://localhost:8080/ida-ws/';

  /*intercept(req: HttpRequest<any>, next: HttpHandler) {

    // Clone the request and replace the original headers with
    // cloned headers, updated with the authorization.
    const authReq = req.clone({
      headers: req.headers.set('Content-Type', 'application/json')
    });

    // send cloned request with header to the next handler.
    return next.handle(authReq);
  }*/

  constructor(private http: HttpClient) {
  }

  getFullUrl(path: string) {
    return this.hosturl + path;
  }

  public getNPRequest(path: string): Observable<any> {
    return this.http.get(this.getFullUrl(path));
  }

  public getRequest(path: string, prmobj: object): Observable<any> {
    let params = new HttpParams();
    for (const x in prmobj) {
      if (prmobj[x] != null) {
        params = params.set(x, prmobj[x]);
      }
    }
    return this.http.get(this.getFullUrl(path), {params: params});
  }
}