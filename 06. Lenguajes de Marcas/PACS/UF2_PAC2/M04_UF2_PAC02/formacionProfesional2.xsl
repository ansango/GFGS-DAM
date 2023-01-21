<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<style type="text/css">
		body{
			background-color: #000000;
		}
		#cuerpo{
			background-color: #C7EDBB;
			width: 900px;
			margin: 0 auto;
			padding:15px;
		}
		.grado{
			font-weight: bolder;
			font-size: 45px;
		}
		.familia{
			font-weight: bolder;
			font-size: 40px;
			margin-left: 20px;
		}
		.ciclo{
			font-weight: bolder;
			font-size: 35px;
			margin-left: 40px;
		}
		.cicloDatos{
			font-weight: bolder;
			font-size: 20px;
			margin-left: 60px;
		}
		.modulos{
			font-weight: bolder;
			font-size: 15px;
			margin-left: 80px;
		}
		.modulo{
			font-weight: bolder;
			font-size: 15px;
			margin-left: 100px;
		}
        </style>
			</head>
			<body>
				<div id="cuerpo">
					<xsl:for-each select="fp/ciclos/ciclo">
						<div class="grado">
							<xsl:value-of select="nombre"/> (<xsl:value-of select="@siglas"/>)</div>
						
						<div class="familia">Familia: <xsl:value-of select="familiaProfesional"/>
						</div>
						<div class="ciclo">Grado: <xsl:value-of select="grado"/>
						</div>
						<div class="cicloDatos">
							<xsl:value-of select="duracion/@unidad"/>: <xsl:value-of select="duracion"/>
						</div>
						<div class="cicloDatos">ECTS: <xsl:value-of select="ects"/>
						</div>
						<div class="modulos">Modulos</div>
						<xsl:apply-templates select="/fp/modulos">
							<xsl:with-param name="siglas" select="@siglas"/>
						</xsl:apply-templates>
					</xsl:for-each>
				</div>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="modulos">
	<xsl:param name="siglas"/>
		<xsl:for-each select="modulo">
			<xsl:if test="ciclos/ciclos/@siglas = $siglas">
				<div class="modulo"> <xsl:value-of select="curso"/> º Cruso - <xsl:value-of select="nombre"/> - (<xsl:value-of select="duracion"/> Horas) - <xsl:value-of select="ects"/> ETCS </div>
			</xsl:if>
			
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
