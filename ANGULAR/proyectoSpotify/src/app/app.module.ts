import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchComponent } from './search/search.component';
import { TarjetasComponent } from './tarjetas/tarjetas.component';
import { ArtistaComponent } from './artista/artista.component';
import { LoadingComponent } from './loading/loading.component';
import { PictureComponent } from './picture/picture.component';
import { DomseguroPipe } from './domseguro.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    TarjetasComponent,
    ArtistaComponent,
    LoadingComponent,
    PictureComponent,
    DomseguroPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
