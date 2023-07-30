package com.example.mp8;

import static com.example.mp8.R.id.webView;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class PdfViewerActivity extends AppCompatActivity {

    public static final String PDF_FILE_NAME = "pdf_file_name";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        String fileName = getIntent().getStringExtra(PDF_FILE_NAME);
        String pdfPath = "file:///android_asset/" + fileName;
        String pdfUrl = "https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdfPath;
        webView.loadUrl(pdfUrl);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
