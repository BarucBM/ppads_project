import { Component, OnInit } from '@angular/core';
import { WeatherCardComponent } from '../../../../shared/components/weather-card/weather-card.component';
import { UserCalendarComponent } from '../../../events/components/user-calendar/user-calendar.component';
import { AuthService } from '../../../../core/auth/services/auth.service';
import { CardModule } from 'primeng/card';
import { SharedModule } from '../../../../shared/modules/shared.module';
import { ButtonModule } from 'primeng/button';
import { FeedComponent } from "../../../feed/feed.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [SharedModule, ButtonModule, CardModule, FeedComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent{  
  constructor(authService: AuthService) {
      authService.getAccessToken();
  }
}
