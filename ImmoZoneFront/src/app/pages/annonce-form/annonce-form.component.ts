import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { WILAYAS } from 'src/app/shared/wilayaData';
import Swal from 'sweetalert2';
import { AnnonceService } from 'src/app/services/annonce.service'; // 👉 Import du service

@Component({
  selector: 'app-annonce-form',
  templateUrl: './annonce-form.component.html',
  styleUrls: ['./annonce-form.component.css']
})
export class AnnonceFormComponent implements OnInit {
  wilayas = WILAYAS;
  isEditMode = false;
  selectedFiles: File[] = [];
  previewUrls: string[] = [];
  annonceForm: FormGroup;

  constructor(private fb: FormBuilder, private annonceService: AnnonceService) { // 👉 injecter AnnonceService
    this.annonceForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      type: ['', Validators.required],
      wilaya: ['', Validators.required],
      numberOfRooms: ['', [Validators.required, Validators.min(1)]],
      price: ['', [Validators.required, Validators.min(0)]],
      photos: [[]] 
    });
  }

  ngOnInit() {}

  onFileChange(event: any) {
    const files: File[] = Array.from(event.target.files);
    if (files.length + this.selectedFiles.length > 6) {
      Swal.fire('Error', 'You can upload a maximum of 5 photos!', 'error');
      return;
    }
    this.selectedFiles = [...this.selectedFiles, ...files];
    this.previewUrls = [];
    this.selectedFiles.forEach(file => {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.previewUrls.push(e.target.result);
      };
      reader.readAsDataURL(file);
    });
  }

  onSubmit() {
    if (this.annonceForm.valid) {
      const annonceData = this.annonceForm.value;
      this.annonceService.addAnnonce(annonceData).subscribe({
        next: response => {
          Swal.fire('Success', 'Annonce ajoutée avec succès!', 'success');
          this.cancel();
        },
        error: error => {
          Swal.fire('Error', 'Erreur lors de l\'ajout de l\'annonce', 'error');
          console.error('Erreur lors de l\'ajout', error);
        }
      });
    } else {
      Swal.fire('Invalid', 'Veuillez remplir correctement le formulaire', 'warning');
    }
  }

  cancel() {
    this.annonceForm.reset();
    this.selectedFiles = [];
    this.previewUrls = [];
  }
}