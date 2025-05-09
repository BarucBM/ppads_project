import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-feed',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './feed.component.html',
  styleUrl: './feed.component.scss'
})
export class FeedComponent {
games = [
    {
      title: 'Super Mario Bros. U Deluxe',
      ratings: '1,067,054',
      image: ''
    },
    {
      title: 'Shadow of the Colossus',
      ratings: '278,054',
      image: ''
    },
    {
      title: 'God of War',
      ratings: '905,742',
      image: ''
    }
  ];

}
