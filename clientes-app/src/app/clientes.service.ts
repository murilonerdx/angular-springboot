import { Injectable } from '@angular/core';
import { Cliente } from './clientes/clientes';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor() { }
  getCliente() : Cliente{
    let cliente : Cliente = new Cliente();
    cliente.nome = 'Murilo de tal';
    cliente.cpf = '88888888888'
    return cliente;
  }
}
