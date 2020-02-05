import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ErrorHandler, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { GlobalErrorHandler } from './_helpers/global-error-handler';
import { HttpErrorInterceptor } from './_helpers/http-error-interceptor';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CodeBookComponent } from './components/code-book/code-book.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { ConfirmationModalComponent } from './_shared/confirmation-modal/confirmation-modal.component';
import { JwtInterceptor } from './_helpers/jwt.interceptor';
import { FindEntityModalComponent } from './components/code-book/find-entity-modal/find-entity-modal.component';
import { AddEntityComponent } from './components/add-entity/add-entity.component';
import { FindEntitySecondModalComponent } from './components/code-book/find-entity-second-modal/find-entity-second-modal.component';
import { LegalEntitiesComponent } from './components/add-entity/legal-entities/legal-entities.component';
import { LegalEntitiesModelComponent } from './components/add-entity/legal-entities/legal-entities-model/legal-entities-model.component';
import { SparqlQuestionsComponent } from './components/add-entity/sparql-questions/sparql-questions.component';
import { SparqlQuestionsModalComponent } from './components/add-entity/sparql-questions/sparql-questions-modal/sparql-questions-modal.component';
import { QuestionPropertiesModalComponent } from './components/add-entity/sparql-questions/question-properties-modal/question-properties-modal.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    ConfirmationModalComponent,
    CodeBookComponent,
    FindEntityModalComponent,
    AddEntityComponent,
    FindEntitySecondModalComponent,
    LegalEntitiesComponent,
    LegalEntitiesModelComponent,
    SparqlQuestionsComponent,
    SparqlQuestionsModalComponent,
    QuestionPropertiesModalComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: ErrorHandler,
      useClass: GlobalErrorHandler
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }
  ],
  entryComponents: [
    ConfirmationModalComponent,
    FindEntityModalComponent,
    FindEntitySecondModalComponent,
    LegalEntitiesModelComponent,
    SparqlQuestionsModalComponent,
    QuestionPropertiesModalComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
