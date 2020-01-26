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
import { OntologyTypesComponent } from './components/add-entity/ontology-types/ontology-types.component';
import { OntologyTypesModalComponent } from './components/add-entity/ontology-types/ontology-types-modal/ontology-types-modal.component';
import { OntologyPropertiesComponent } from './components/add-entity/ontology-properties/ontology-properties.component';
import { OntologyPropertiesModalComponent } from './components/add-entity/ontology-properties/ontology-properties-modal/ontology-properties-modal.component';
import { FindEntitySecondModalComponent } from './components/code-book/find-entity-second-modal/find-entity-second-modal.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    ConfirmationModalComponent,
    CodeBookComponent,
    FindEntityModalComponent,
    AddEntityComponent,
    OntologyTypesComponent,
    OntologyTypesModalComponent,
    OntologyPropertiesComponent,
    OntologyPropertiesModalComponent,
    FindEntitySecondModalComponent,
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
    OntologyTypesModalComponent,
    OntologyPropertiesModalComponent,
    FindEntitySecondModalComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
