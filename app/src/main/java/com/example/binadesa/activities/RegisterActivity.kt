package com.example.binadesa.activities

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.databinding.ActivityRegisterBinding
import java.util.Calendar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // DROPDOWN AGAMA

        val agamaList = arrayOf(
            "Islam",
            "Kristen",
            "Katolik",
            "Hindu",
            "Buddha",
            "Konghucu"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            agamaList
        )

        binding.edtAgama.setAdapter(adapter)

        // DATE PICKER

        binding.edtTanggalLahir.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, y, m, d ->

                    val tanggal = "$d/${m + 1}/$y"

                    binding.edtTanggalLahir.setText(tanggal)

                },
                year,
                month,
                day
            )

            datePicker.show()
        }

        // BUTTON REGISTER

        binding.btnRegister.setOnClickListener {

            val nama = binding.edtNama.text.toString().trim()
            val tanggal = binding.edtTanggalLahir.text.toString().trim()
            val agama = binding.edtAgama.text.toString().trim()
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            val confirm = binding.edtConfirmPassword.text.toString().trim()

            val gender = when {

                binding.rbLaki.isChecked -> "Laki-laki"

                binding.rbPerempuan.isChecked -> "Perempuan"

                else -> ""
            }

            // RESET ERROR

            binding.edtNama.error = null
            binding.edtTanggalLahir.error = null
            binding.edtAgama.error = null
            binding.edtUsername.error = null
            binding.edtPassword.error = null
            binding.edtConfirmPassword.error = null

            binding.txtGenderError.visibility = View.GONE

            when {

                nama.isEmpty() -> {

                    binding.edtNama.error =
                        "Nama wajib diisi"

                    binding.edtNama.requestFocus()
                }

                tanggal.isEmpty() -> {

                    binding.edtTanggalLahir.error =
                        "Tanggal lahir wajib diisi"

                    binding.edtTanggalLahir.requestFocus()
                }

                gender.isEmpty() -> {

                    binding.txtGenderError.visibility = View.VISIBLE
                }

                agama.isEmpty() -> {

                    binding.edtAgama.error =
                        "Agama wajib dipilih"

                    binding.edtAgama.requestFocus()
                }

                username.isEmpty() -> {

                    binding.edtUsername.error =
                        "Username wajib diisi"

                    binding.edtUsername.requestFocus()
                }

                password.isEmpty() -> {

                    binding.edtPassword.error =
                        "Password wajib diisi"

                    binding.edtPassword.requestFocus()
                }

                confirm.isEmpty() -> {

                    binding.edtConfirmPassword.error =
                        "Confirm Password wajib diisi"

                    binding.edtConfirmPassword.requestFocus()
                }

                password != confirm -> {

                    binding.edtConfirmPassword.error =
                        "Password tidak sama"

                    binding.edtConfirmPassword.requestFocus()
                }

                else -> {

                    val sharedPref =
                        getSharedPreferences("user_data", MODE_PRIVATE)

                    sharedPref.edit()
                        .putString("nama", nama)
                        .putString("tanggal", tanggal)
                        .putString("gender", gender)
                        .putString("agama", agama)
                        .putString("username", username)
                        .putString("password", password)
                        .apply()

                    finish()
                }
            }
        }
    }
}