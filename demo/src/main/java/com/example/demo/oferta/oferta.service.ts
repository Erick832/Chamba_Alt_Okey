import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Oferta } from './oferta.model';

@Injectable({
  providedIn: 'root',
})
export class OfertaService {
  constructor(private http: HttpClient) {}

  //{{base_url}}/employer/ofertas?type=2
  getAllPageable(type: number) {
    let params = new HttpParams();
    params = params.append('type', page);

    return this.http.get<any>(`${this.apiBase}/ofertas/pageable`, {
      params,
    });
  }

  getAll() {
    return this.http.get<Oferta[]>(`${this.apiBase}/ofertas`);
  }

  get(id: number) {
    return this.http.get(`${this.apiBase}/ofertas/${id}`);
  }

  create(Oferta: Oferta) {
    return this.http.post(`${this.apiBase}/ofertas`, oferta);
  }

  update(Oferta: Oferta) {
    return this.http.put(`${this.apiBase}/ofertas`, oferta);
  }

  delete(id: number) {
    return this.http.delete(`${this.apiBase}/ofertas/${id}`);
  }

}
