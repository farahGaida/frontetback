import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ContactService } from '../../services/contact.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contactForm: FormGroup;
  selectedFiles: File[] = [];
  previewUrls: string[] = [];

  constructor(private fb: FormBuilder,private contactService: ContactService) {
    this.contactForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.minLength(3)]],
      message: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  onSubmit() {   if (this.contactForm.valid) {
    const contactData = this.contactForm.value;
    this.contactService.addContact(contactData).subscribe({
      next: response => {
        Swal.fire('Success', 'contact ajoutée avec succès!', 'success');
        this.cancel();
      },
      error: error => {
        Swal.fire('Error', 'Erreur lors de l\'ajout de l\'contact', 'error');
        console.error('Erreur lors de l\'ajout', error);
      }
    });
  } else {
    Swal.fire('Invalid', 'Veuillez remplir correctement le formulaire', 'warning');
  }
  

  }
  cancel() {
    this.contactForm.reset();
    this.selectedFiles = [];
    this.previewUrls = [];
  }
}
