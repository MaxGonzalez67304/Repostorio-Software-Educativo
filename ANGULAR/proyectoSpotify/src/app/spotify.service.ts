import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SpotifyService {

  constructor(private http: HttpClient) {
    console.log("Spotify Service listo");
  }

  getQuery(query: string) {
    const url = `https://api.spotify.com/v1/${query}`;
    const headers = new HttpHeaders({ 'Authorization': 'Bearer BQArrQIWnQZN2zyPWjl4QsYAlkvBb2Y7nfqL-cSfd9LWFCAxhZr6xFViBiaQ3wC9ZTqfvE97FgkmogF2_dU' })
    return this.http.get(url, { headers });
  }

  getArtistas(termino: string) {
    console.log(termino);
    return this.getQuery(`search?q=${termino}&type=artist&limit=6`)
      .pipe(map((data: any) => (data.artists.items)));
  }

  getArtista(id: string) {
    return this.getQuery(`artists/${id}`);
  }
  getTopTracks(id: string) {
    return this.getQuery(`artists/${id}/top-tracks?country=us`)
      .pipe(map((data: any) => data['tracks']));
  }

}
