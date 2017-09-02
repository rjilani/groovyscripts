@Grab('com.itextpdf:itextpdf:5.4.2')

import com.itextpdf.text.pdf.parser.*
import com.itextpdf.text.pdf.*

def pdf = new PdfReader(/C:\Users\rjilan01\Documents\teranet_docs\pdf_docs\EXECUTION CERTIFICATE.pdf/)
def maxPages = pdf.numberOfPages + 1
def parser = new PdfTextExtractor()

(1..<maxPages).each { pageNumber ->
    println parser.getTextFromPage(pdf, pageNumber)
}