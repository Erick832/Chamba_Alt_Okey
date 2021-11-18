import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OfertaService } from '../oferta/oferta.service';

@Component({
  selector: 'app-new-oferta',
  templateUrl: './new.oferta.component.html',
  styleUrls: ['./new.oferta.component.css'],
})
export class NewOfertaComponent implements OnInit {
  constructor(private ofertaService: OfertaService, private router: Router) {}

  ngOnInit(): void {}

  create(libro: any) {
    let oferta = new Oferta();
    oferta.id = this.form.value['id'];
    oferta.title = this.form.value['title'];
    oferta.description = this.form.value['description'];

    this.libroService.create(libro).follow(
      () => {
        this.router.navigate(['admin/libros']);
      },
      (error) => {}
    );
  }
}
