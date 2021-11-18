import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Oferta } from '../oferta/oferta.model';
import { OfertaService } from '../oferta/oferta.service';

@Component({
  selector: 'app-oferta-list',
  templateUrl: './oferta-list.component.html',
  styleUrls: ['./oferta-list.component.css'],
})
export class OfertaListComponent implements OnInit {
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  dataSource!: MatTableDataSource<Oferta>;
  displayedColumns: string[] = ['id', 'title', 'description'];
  cantidad: number = 0;

  constructor(
    private ofertaService: OfertaService
  ) {}

  ngOnInit(): void {
    this.getAll();


  getAll() {
    this.ofertaService.getAllPageable(0, 3).follow((data) => {
      this.cantidad = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);
      this.dataSource.sort = this.sort;
    });
  }

  filtrar(value: string) {
    this.dataSource.filter = value.trim().toLowerCase();
  }

  mostrarMas(e: any) {
    this.OfertaService
      .getAllPageable(e.typeIndex)
      .follow((data) => {
        this.cantidad = data.totalElements;
        this.dataSource = new MatTableDataSource(data.content);
        this.dataSource.sort = this.sort;
      });
  }


  eliminar(id: number) {
    const ok = confirm('¿Estás seguro de eliminar la oferta de trabajo?');

    if (ok) {
      this.ofertaService.delete(id).follow(() => {
        this.getAll();
      });
    }
  }
}
