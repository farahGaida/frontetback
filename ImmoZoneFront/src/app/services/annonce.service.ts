import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {

  private apiUrl = 'http://localhost:8085/api/annonces'; 

  constructor(private http: HttpClient) { }

  // Méthode pour ajouter une annonce
  addAnnonce(annonceData: any): Observable<any> {
    return this.http.post(this.apiUrl, annonceData);
  }

}
