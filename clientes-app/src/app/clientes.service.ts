import { Injectable } from '@angular/core';
import { Cliente } from './clientes/clientes';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

import {environment} from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  apiURL: string = environment.apiURL;

  constructor(private http : HttpClient) {
   }

   salvar(cliente : Cliente): Observable<Cliente>{
      return this.http.post<Cliente>(`${this.apiURL}/api/clientes`, cliente);
   }

   atualizar(cliente : Cliente): Observable<any>{
    return this.http.put<Cliente>(`${this.apiURL}/api/clientes/${cliente.id}`, cliente);
 }

 deletar(cliente : Cliente): Observable<any>{
  return this.http.delete<Cliente>(`${this.apiURL}/api/clientes/${cliente.id}`);
}

   getClientes(): Observable<Cliente[]>{
     return this.http.get<Cliente[]>(`${this.apiURL}/api/clientes`);
   }
   
   getClienteById(id: number) : Observable<Cliente>{
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
   }
}
